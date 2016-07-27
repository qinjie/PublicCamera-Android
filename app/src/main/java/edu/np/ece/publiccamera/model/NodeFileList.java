package edu.np.ece.publiccamera.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class NodeFileList {

    @SerializedName("items")
    @Expose
    private List<NodeFile> items = new ArrayList<NodeFile>();
    @SerializedName("_links")
    @Expose
    private edu.np.ece.publiccamera.model.Links Links;
    @SerializedName("_meta")
    @Expose
    private edu.np.ece.publiccamera.model.Meta Meta;

    /**
     *
     * @return
     * The items
     */
    public List<NodeFile> getNodeFiles() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setNodeFiles(List<NodeFile> items) {
        this.items = items;
    }

    /**
     *
     * @return
     * The Links
     */
    public edu.np.ece.publiccamera.model.Links getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(edu.np.ece.publiccamera.model.Links Links) {
        this.Links = Links;
    }

    /**
     *
     * @return
     * The Meta
     */
    public edu.np.ece.publiccamera.model.Meta getMeta() {
        return Meta;
    }

    /**
     *
     * @param Meta
     * The _meta
     */
    public void setMeta(edu.np.ece.publiccamera.model.Meta Meta) {
        this.Meta = Meta;
    }

}