package multiscripter.classusage.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Realizes entity "Repository item".
 *
 * @author Multiscripter
 * @version 2019-12-04
 * @since 2019-12-04
 */
public class Item {

    @JsonProperty("id")
    private long id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("private")
    private boolean access;

    @JsonProperty("owner")
    private Object owner;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("fork")
    private boolean fork;

    @JsonProperty("url")
    private String url;

    @JsonProperty("forks_url")
    private String forksUrl;

    @JsonProperty("keys_url")
    private String keysUrl;

    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;

    @JsonProperty("teams_url")
    private String teamsUrl;

    @JsonProperty("hooks_url")
    private String hooksUrl;

    @JsonProperty("issue_events_url")
    private String issueEventsUrl;

    @JsonProperty("events_url")
    private String eventsUrl;

    @JsonProperty("assignees_url")
    private String assigneesUrl;

    @JsonProperty("branches_url")
    private String branchesUrl;

    @JsonProperty("tags_url")
    private String tagsUrl;

    @JsonProperty("blobs_url")
    private String blobsUrl;

    @JsonProperty("git_tags_url")
    private String gitTagsUrl;

    @JsonProperty("git_refs_url")
    private String gitRefsUrl;

    @JsonProperty("trees_url")
    private String treesUrl;

    @JsonProperty("statuses_url")
    private String statusesUrl;

    @JsonProperty("languages_url")
    private String languagesUrl;

    @JsonProperty("stargazers_url")
    private String stargazersUrl;

    @JsonProperty("contributors_url")
    private String contributorsUrl;

    @JsonProperty("subscribers_url")
    private String subscribersUrl;

    @JsonProperty("subscription_url")
    private String subscriptionUrl;

    @JsonProperty("commits_url")
    private String commitsUrl;

    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;

    @JsonProperty("contents_url")
    private String contentsUrl;

    @JsonProperty("compare_url")
    private String compareUrl;

    @JsonProperty("merges_url")
    private String mergesUrl;

    @JsonProperty("archive_url")
    private String archiveUrl;

    @JsonProperty("downloads_url")
    private String downloadsUrl;

    @JsonProperty("issues_url")
    private String issuesUrl;

    @JsonProperty("pulls_url")
    private String pulls_Url;

    @JsonProperty("milestones_url")
    private String milestonesUrl;

    @JsonProperty("notifications_url")
    private String notificationsUrl;

    @JsonProperty("labels_url")
    private String labelsUrl;

    @JsonProperty("releases_url")
    private String releasesUrl;

    @JsonProperty("deployments_url")
    private String deploymentsUrl;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("pushed_at")
    private String pushedAt;

    @JsonProperty("git_url")
    private String gitUrl;

    @JsonProperty("ssh_url")
    private String sshUrl;

    @JsonProperty("clone_url")
    private String cloneUrl;

    @JsonProperty("svn_url")
    private String svnUrl;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("size")
    private long size;

    @JsonProperty("stargazers_count")
    private long stargazersCount;

    @JsonProperty("watchers_count")
    private long watchersCount;

    @JsonProperty("language")
    private String language;

    @JsonProperty("has_issues")
    private boolean hasIssues;

    @JsonProperty("has_projects")
    private boolean hasProjects;

    @JsonProperty("has_downloads")
    private boolean hasDownloads;

    @JsonProperty("has_wiki")
    private boolean hasWiki;

    @JsonProperty("has_pages")
    private boolean hasPages;

    @JsonProperty("forks_count")
    private int forksCount;

    @JsonProperty("mirror_url")
    private String mirrorUrl;

    @JsonProperty("archived")
    private boolean archived;

    @JsonProperty("disabled")
    private boolean disabled;

    @JsonProperty("open_issues_count")
    private int openIssuesCount;

    @JsonProperty("license")
    private Object license;

    @JsonProperty("forks")
    private int forks;

    @JsonProperty("open_issues")
    private int openIssues;

    @JsonProperty("watchers")
    private int watchers;

    @JsonProperty("default_branch")
    private String defaultBranch;

    @JsonProperty("score")
    private String score;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Gets full repository name.
     * @return full repository name.
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Gets repository name.
     * @return repository name.
     */
    public String getName() {
        return this.name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public void setPulls_Url(String pulls_Url) {
        this.pulls_Url = pulls_Url;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setStargazersCount(long stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public void setWatchersCount(long watchersCount) {
        this.watchersCount = watchersCount;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public void setHasProjects(boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public void setHasPages(boolean hasPages) {
        this.hasPages = hasPages;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public void setMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public void setLicense(Object license) {
        this.license = license;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Item{id: %d, fullName: %s}",
            this.id, this.fullName);
    }
}
