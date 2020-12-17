
package com.mbinfo.oumodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Format_ {

    @SerializedName("preview_url")
    @Expose
    private String previewUrl;
    @SerializedName("download_url")
    @Expose
    private String downloadUrl;
    @SerializedName("format")
    @Expose
    private String format;

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
