package com.test.railway.doMain;

/**
 * @author :chensuzi
 * @ClassName :ValidateActionJson
 * @Description :TODO
 * @cersion :V1.0
 * @date :2020/4/181449
 **/
public class dto {

    /**
     * packageName : string
     * apkVersion : string
     * remark : string
     * disable : true
     * id : string
     * name : string
     */

    private String packageName;
    private String apkVersion;
    private String remark;
    private boolean disable;
    private String id;
    private String name;

    public dto(String packageName, String apkVersion,String remark,boolean disable,String name) {
        this.packageName = packageName;
        this.apkVersion = apkVersion;
        this.remark = remark;
        this.disable = disable;
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApkVersion() {
        return apkVersion;
    }

    public void setApkVersion(String apkVersion) {
        this.apkVersion = apkVersion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
