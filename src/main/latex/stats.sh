#!/bin/bash
# stats.sh
# Copyright 2005 by Norbert Elbrecht
# $Id: stats.sh,v 1.6 2006/02/06 17:29:34 norbert Exp $
# changelog:
# Sat Aug  3 15:16:04 CEST 2013
#  - adapted to debian wheezy.
#  - changed calculation interval from 1.5 to 3.5 years.

WINDOWWIDTHS=3  # short sliding window
WINDOWWIDTHL=19 # long sliding window
WINDOWWIDTHG=30 # the longer of the sliding windows in calendar days

# PSQL=/usr/local/pgsql/bin/psql
# PORT=15432
# HOST=localhost
# DB=dispo
# USER=superne
PSQL=/usr/bin/psql
PORT=5432
HOST=localhost
DB=dispo
USER=superne

cat stats-1.tex >stats-stats.tex

# make an up-to-date customerbydate table shortened to reflect
# (appropriate!) 3.5 year data:
OPTS='--echo-all'
$PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} <<EOF
 DROP TABLE customerbyday CASCADE;
 CREATE TABLE customerbyday AS
  SELECT "Dat"::date, "Kuerzel", COALESCE(SUM("Preis"), 0) AS "Preis"
  FROM "Auftragsannahme" 
  WHERE "Dat"::date >= now()::date - INTERVAL '3.5 year ${WINDOWWIDTHG} days'
  GROUP BY "Dat", "Kuerzel";
 CREATE UNIQUE INDEX customerbyday_dat_kuerzel
  ON customerbyday ("Dat", "Kuerzel");
EOF

# create a file with a list of customers that actually created revenue
# relevant for a 3.5 year list:
OPTS='-F , -t -A -o r.csv'
$PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} -c\
 'SELECT "Kuerzel" FROM customerbyday GROUP BY "Kuerzel"'

# determine the overall min and max dates for all plots, that is: plot
# exactly 3.5 year of data from today into the past:
plotmindate=`OPTS="-F , -t -A"
    $PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} -c\
     "SELECT CAST(now() - INTERVAL '3.5 year' AS date)"`
plotmaxdate=`OPTS="-F , -t -A"
    $PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} -c\
     "SELECT CAST(now() - INTERVAL '1 day' AS date)"`

#for i in `head -30 r.csv` 
#for i in `echo 210; echo 712; echo 937; echo 546`
#for i in `echo 1021`
for i in `cat r.csv`
 do
    kuerzel=`
    OPTS="-F , -t -A"
    $PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} -c\
     "SELECT \"Kuerzel\", \"Kd-Nr\" FROM \"Rechnungskunden\" WHERE \"ID\"=${i}"\
     |sed -e 's/\&/\\\\\\&/g'`
    qkuerzel=`echo $kuerzel|sed -e 's/\&/\\\\\\&/g'`

    echo "processing $i, $kuerzel"
    echo "\section*{$kuerzel}" >>stats-stats.tex

    OPTS="-F , -t -A -o ${i}.csv"
    $PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} -c\
     "SELECT * FROM customersum(${WINDOWWIDTHL},${i})"
    sed s/,/\ /g  ${i}.csv >${WINDOWWIDTHL}-${i}.dat

    gnuplot  >>stats-stats.tex <<EOF 
 set terminal latex
 set grid
 set xdata time
 set timefmt "%Y-%m-%d"
 set format x "%b"
 set key off
 set title "${WINDOWWIDTHL}-$qkuerzel"
 plot ["$plotmindate":"$plotmaxdate"] "${WINDOWWIDTHL}-${i}.dat" using 1:2 with lines
EOF

    echo "\newline" >>stats-stats.tex
#    echo "\pagebreak" >>stats-stats.tex

    OPTS="-F , -t -A -o ${i}.csv"
    $PSQL -U ${USER} -p ${PORT} -h ${HOST} ${DB} ${OPTS} -c\
     "SELECT * FROM customersum(${WINDOWWIDTHS},${i})"
    sed s/,/\ /g  ${i}.csv >${WINDOWWIDTHS}-${i}.dat

    gnuplot  >>stats-stats.tex <<EOF 
 set terminal latex
 set grid
 set xdata time
 set timefmt "%Y-%m-%d"
 set format x "%b"
 set key off
 set title "${WINDOWWIDTHS}-$qkuerzel"
 plot ["$plotmindate":"$plotmaxdate"] "${WINDOWWIDTHS}-${i}.dat" using 1:2 with filledcurves x1
EOF

    echo "\newline" >>stats-stats.tex
    if ((${i}%2==0))  ; then
        echo "\pagebreak" >>stats-stats.tex
    fi

    rm ${i}.csv ${WINDOWWIDTHL}-${i}.dat ${WINDOWWIDTHS}-${i}.dat

done

cat stats-2.tex >>stats-stats.tex
pdflatex stats-stats
# open stats-stats.pdf

# assume target is created and chmod 3773:
cp stats-stats.pdf /home/bikesyndikat/inbox/
chmod o-rwx /home/bikesyndikat/inbox/stats-stats.pdf

# Local Variables:
# compile-command: "./stats.sh"
# eval:(local-set-key [f7] 'compile)
# End:
