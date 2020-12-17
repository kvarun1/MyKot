
package com.mbinfo.oumodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Container {

    @SerializedName("download_url")
    @Expose
    private String downloadUrl;
    @SerializedName("format")
    @Expose
    private String format;

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
