package edu.np.ece.publiccamera.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class FloorData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("floorId")
    @Expose
    private String floorId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("marker")
    @Expose
    private String marker;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The floorId
     */
    public String getFloorId() {
        return floorId;
    }

    /**
     *
     * @param floorId
     * The floorId
     */
    public void setFloorId(String floorId) {
        this.floorId = floorId;
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
     * The value
     */
    public Integer getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     *
     * @return
     * The marker
     */
    public String getMarker() {
        return marker;
    }

    /**
     *
     * @param marker
     * The marker
     */
    public void setMarker(String marker) {
        this.marker = marker;
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

    @Override
    public String toString() {
        return "FloorData{" +
                "id='" + id + '\'' +
                ", floorId='" + floorId + '\'' +
                ", label='" + label + '\'' +
                ", value=" + value +
                ", marker='" + marker + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                '}';
    }
}