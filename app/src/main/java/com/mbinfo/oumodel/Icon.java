
package com.mbinfo.oumodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {

    @SerializedName("containers")
    @Expose
    private List<Container> containers = null;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vector_sizes")
    @Expose
    private List<VectorSize> vectorSizes = null;
    @SerializedName("is_premium")
    @Expose
    private Boolean isPremium;
    @SerializedName("icon_id")
    @Expose
    private Integer iconId;
    @SerializedName("raster_sizes")
    @Expose
    private List<RasterSize> rasterSizes = null;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("styles")
    @Expose
    private List<Style> styles = null;
    @SerializedName("is_icon_glyph")
    @Expose
    private Boolean isIconGlyph;

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<VectorSize> getVectorSizes() {
        return vectorSizes;
    }

    public void setVectorSizes(List<VectorSize> vectorSizes) {
        this.vectorSizes = vectorSizes;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public List<RasterSize> getRasterSizes() {
        return rasterSizes;
    }

    public void setRasterSizes(List<RasterSize> rasterSizes) {
        this.rasterSizes = rasterSizes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public Boolean getIsIconGlyph() {
        return isIconGlyph;
    }

    public void setIsIconGlyph(Boolean isIconGlyph) {
        this.isIconGlyph = isIconGlyph;
    }

}
