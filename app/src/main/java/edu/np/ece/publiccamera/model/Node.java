package edu.np.ece.publiccamera.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Node {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("serial")
    @Expose
    private String serial;
    @SerializedName("floorId")
    @Expose
    private Object floorId;
    @SerializedName("projectId")
    @Expose
    private String projectId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("created")
    @Expose
    private Object created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("latestCrowdIndex")
    @Expose
    private NodeData latestCrowdIndex;
    @SerializedName("latestNodeFile")
    @Expose
    private NodeFile latestNodeFile;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial The serial
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return The floorId
     */
    public Object getFloorId() {
        return floorId;
    }

    /**
     * @param floorId The floorId
     */
    public void setFloorId(Object floorId) {
        this.floorId = floorId;
    }

    /**
     * @return The projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId The projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The created
     */
    public Object getCreated() {
        return created;
    }

    /**
     * @param created The created
     */
    public void setCreated(Object created) {
        this.created = created;
    }

    /**
     * @return The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * @param modified The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    public NodeData getLatestCrowdIndex() {
        return latestCrowdIndex;
    }

    public void setLatestCrowdIndex(NodeData latestCrowdIndex) {
        this.latestCrowdIndex = latestCrowdIndex;
    }

    public NodeFile getLatestNodeFile() {
        return latestNodeFile;
    }

    public void setLatestNodeFile(NodeFile latestNodeFile) {
        this.latestNodeFile = latestNodeFile;
    }
}