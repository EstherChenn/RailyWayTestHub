package com.test.railway.doMain;

public class loginBack {

    /**
     * code : 200
     * success : true
     * message : 请求成功
     * result : {"item1":{"account":"cszsq01","password":"","code":null,"organizationId":"46c061ca-944a-4d46-bb13-abaa00ec8b5f",
     * "departmentId":"0607060e-eab2-4ee9-b46e-ac40010fd879","userType":1,"sex":0,"description":"北京铁路局|管理中心|北京工务处|北京工务段|双桥车间",
     * "isAdmin":false,"permissions":null,"expiresTime":"0001-01-01T00:00:00","clientType":1,
     * "isRemain":false,"isReplace":false,"token":"SSOeeca666e20964d7dacd528f79825b29e","phoneNum":"13897484848",
     * "lastUpdateTime":"2021-02-01T14:28:12.845772","roleId":"29bc1e0e-c87c-4660-8c70-ac400116d1e6",
     * "roleName":"处级用户","remark":"","disable":false,"id":"0badba77-7375-4aae-8904-ac440116db18","name":"cszsq01"},
     * "item2":"8c46f7bc-357b-41bb-af04-acb900f89d3a"}
     * other : null
     */

    private int code;
    private boolean success;
    private String message;
    private ResultBean result;
    private Object other;

    public loginBack(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public static class ResultBean {
        /**
         * item1 : {"account":"cszsq01","password":"","code":null,"organizationId":"46c061ca-944a-4d46-bb13-abaa00ec8b5f","departmentId":"0607060e-eab2-4ee9-b46e-ac40010fd879","userType":1,"sex":0,"description":"北京铁路局|管理中心|北京工务处|北京工务段|双桥车间","isAdmin":false,"permissions":null,"expiresTime":"0001-01-01T00:00:00","clientType":1,"isRemain":false,"isReplace":false,"token":"SSOeeca666e20964d7dacd528f79825b29e","phoneNum":"13897484848","lastUpdateTime":"2021-02-01T14:28:12.845772","roleId":"29bc1e0e-c87c-4660-8c70-ac400116d1e6","roleName":"处级用户","remark":"","disable":false,"id":"0badba77-7375-4aae-8904-ac440116db18","name":"cszsq01"}
         * item2 : 8c46f7bc-357b-41bb-af04-acb900f89d3a
         */

        private Item1Bean item1;
        private String item2;

        public Item1Bean getItem1() {
            return item1;
        }

        public void setItem1(Item1Bean item1) {
            this.item1 = item1;
        }

        public String getItem2() {
            return item2;
        }

        public void setItem2(String item2) {
            this.item2 = item2;
        }

        public static class Item1Bean {
            /**
             * account : cszsq01
             * password :
             * code : null
             * organizationId : 46c061ca-944a-4d46-bb13-abaa00ec8b5f
             * departmentId : 0607060e-eab2-4ee9-b46e-ac40010fd879
             * userType : 1
             * sex : 0
             * description : 北京铁路局|管理中心|北京工务处|北京工务段|双桥车间
             * isAdmin : false
             * permissions : null
             * expiresTime : 0001-01-01T00:00:00
             * clientType : 1
             * isRemain : false
             * isReplace : false
             * token : SSOeeca666e20964d7dacd528f79825b29e
             * phoneNum : 13897484848
             * lastUpdateTime : 2021-02-01T14:28:12.845772
             * roleId : 29bc1e0e-c87c-4660-8c70-ac400116d1e6
             * roleName : 处级用户
             * remark :
             * disable : false
             * id : 0badba77-7375-4aae-8904-ac440116db18
             * name : cszsq01
             */

            private String account;
            private String password;
            private Object code;
            private String organizationId;
            private String departmentId;
            private int userType;
            private int sex;
            private String description;
            private boolean isAdmin;
            private Object permissions;
            private String expiresTime;
            private int clientType;
            private boolean isRemain;
            private boolean isReplace;
            private String token;
            private String phoneNum;
            private String lastUpdateTime;
            private String roleId;
            private String roleName;
            private String remark;
            private boolean disable;
            private String id;
            private String name;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
            }

            public String getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(String organizationId) {
                this.organizationId = organizationId;
            }

            public String getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(String departmentId) {
                this.departmentId = departmentId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isIsAdmin() {
                return isAdmin;
            }

            public void setIsAdmin(boolean isAdmin) {
                this.isAdmin = isAdmin;
            }

            public Object getPermissions() {
                return permissions;
            }

            public void setPermissions(Object permissions) {
                this.permissions = permissions;
            }

            public String getExpiresTime() {
                return expiresTime;
            }

            public void setExpiresTime(String expiresTime) {
                this.expiresTime = expiresTime;
            }

            public int getClientType() {
                return clientType;
            }

            public void setClientType(int clientType) {
                this.clientType = clientType;
            }

            public boolean isIsRemain() {
                return isRemain;
            }

            public void setIsRemain(boolean isRemain) {
                this.isRemain = isRemain;
            }

            public boolean isIsReplace() {
                return isReplace;
            }

            public void setIsReplace(boolean isReplace) {
                this.isReplace = isReplace;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
            }

            public String getLastUpdateTime() {
                return lastUpdateTime;
            }

            public void setLastUpdateTime(String lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public String getRoleId() {
                return roleId;
            }

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
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
    }
}
