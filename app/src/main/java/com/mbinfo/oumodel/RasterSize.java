
package com.mbinfo.oumodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RasterSize {

    @SerializedName("size_height")
    @Expose
    private Integer sizeHeight;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("size_width")
    @Expose
    private Integer sizeWidth;
    @SerializedName("formats")
    @Expose
    private List<Format_> formats = null;

    public Integer getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(Integer sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Integer sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public List<Format_> getFormats() {
        return formats;
    }

    public void setFormats(List<Format_> formats) {
        this.formats = formats;
    }

}
