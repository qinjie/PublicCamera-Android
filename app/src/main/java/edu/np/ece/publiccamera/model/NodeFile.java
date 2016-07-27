package edu.np.ece.publiccamera.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class NodeFile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nodeId")
    @Expose
    private Integer nodeId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("fileName")
    @Expose
    private String fileName;
    @SerializedName("fileType")
    @Expose
    private String fileType;
    @SerializedName("fileSize")
    @Expose
    private Integer fileSize;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("fileUrl")
    @Expose
    private String fileUrl;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The nodeId
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     *
     * @param nodeId
     * The nodeId
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     *
     * @return
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     * The fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     * The fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return
     * The fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     *
     * @param fileType
     * The fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     *
     * @return
     * The fileSize
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize
     * The fileSize
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     * The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     * The fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     *
     * @param fileUrl
     * The fileUrl
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     *
     * @return
     * The thumbnailUrl
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     *
     * @param thumbnailUrl
     * The thumbnailUrl
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

}