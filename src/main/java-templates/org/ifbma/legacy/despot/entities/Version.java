package org.ifbma.legacy.despot.entities;

public final class Version {

    private static final String title = "${project.name}";
    private static final String vendor = "${project.organization.name}";
    private static final String version = "${project.version}";
    private static final String artifactId = "${project.artifactId}";
    private static final String groupId = "${project.groupId}";

    public static String getTitle() {
        return title;
    }

    public static String getVendor() {
        return vendor;
    }

    public static String getVersion() {
        return version;
    }

    public static String getArtifactId() {
        return artifactId;
    }

    public static String getGroupId() {
        return groupId;
    }

    public static String getInfo() {
        StringBuilder sb = new StringBuilder(version);
        sb.append("\nTitle: ").append(title);
        sb.append("\nVendor: ").append(vendor);
        sb.append("\nArtifactId: ").append(artifactId);
        sb.append("\nGroupIdTitle: ").append(groupId);
        sb.append("\nVersion: ").append(version);
        return sb.toString();
    }
}
