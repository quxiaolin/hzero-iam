package org.hzero.iam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * IAM 属性配置
 *
 * @author bojiangzhou 2019/12/11
 */
@ConfigurationProperties(prefix = IamProperties.PREFIX)
public class IamProperties {

    public static final String PREFIX = "hzero.iam";

    private Permission permission = new Permission();
    
    private InitCache initCache = new InitCache();

    /**
     * 单据权限使用租户的类型（当前租户，当前用户所属租户）
     */
    private String docTenantType = "CUSTOM_TENANT";

    /**
     * 是否启用 Root 用户功能，启用 Root 用户功能后，超级用户可以切换到任意租户下
     */
    private boolean enableRoot = false;

    /**
     * 用户登录名正则表达式：6-30位，包含两种不同类型的字符（数字、字母、"-"、"_"）
     */
    private String usernameRegex = "^(((?=.*[0-9])(?=.*[a-zA-Z])|(?=.*[0-9])(?=.*[_-])|(?=.*[a-zA-Z])(?=.*[_-]))[\\w-]{6,30})$";

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public InitCache getInitCache() {
        return initCache;
    }

    public void setInitCache(InitCache initCache) {
        this.initCache = initCache;
    }

    public boolean isEnableRoot() {
        return enableRoot;
    }

    public void setEnableRoot(boolean enableRoot) {
        this.enableRoot = enableRoot;
    }

    public String getDocTenantType() {
        return docTenantType;
    }

    public void setDocTenantType(String docTenantType) {
        this.docTenantType = docTenantType;
    }

    public String getUsernameRegex() {
        return usernameRegex;
    }

    public void setUsernameRegex(String usernameRegex) {
        this.usernameRegex = usernameRegex;
    }

    /**
     * 权限配置
     */
    public static class Permission {
        /**
         * 是否开启刷新权限的功能
         */
        private boolean parsePermission = true;
        /**
         * 跳过解析的服务
         */
        private String skipServices = "register,gateway,swagger";
        /**
         * 是否清除过期权限
         */
        private boolean cleanPermission = false;

        public boolean isParsePermission() {
            return parsePermission;
        }

        public void setParsePermission(boolean parsePermission) {
            this.parsePermission = parsePermission;
        }

        public String getSkipServices() {
            return skipServices;
        }

        public void setSkipServices(String skipServices) {
            this.skipServices = skipServices;
        }

        public boolean isCleanPermission() {
            return cleanPermission;
        }

        public void setCleanPermission(boolean cleanPermission) {
            this.cleanPermission = cleanPermission;
        }
    }

    /**
     * 初始化缓存
     */
    public static class InitCache {
        /**
         * 是否初始化三方登陆方式到缓存
         */
        private boolean openLoginWay = true;
        /**
         * 是否初始化密码策略到缓存
         */
        private boolean passwordPolicy = true;
        /**
         * 是否初始化用户到缓存
         */
        private boolean user = true;
        /**
         * 是否初始化缓存LDAP
         */
        private boolean ldap = true;
        /**
         * 是否初始化缓存客户端
         */
        private boolean client = true;
        /**
         * 是否初始化租户客户化端点信息
         */
        private boolean tenantCustomPoint = false;

        private boolean fieldPermission = false;

        /**
         * 是否初始化单据权限缓存标识
         */
        private boolean docAuth = false;

        public boolean isOpenLoginWay() {
            return openLoginWay;
        }

        public void setOpenLoginWay(boolean openLoginWay) {
            this.openLoginWay = openLoginWay;
        }

        public boolean isPasswordPolicy() {
            return passwordPolicy;
        }

        public void setPasswordPolicy(boolean passwordPolicy) {
            this.passwordPolicy = passwordPolicy;
        }

        public boolean isUser() {
            return user;
        }

        public void setUser(boolean user) {
            this.user = user;
        }

        public boolean isLdap() {
            return ldap;
        }

        public void setLdap(boolean ldap) {
            this.ldap = ldap;
        }

        public boolean isClient() {
            return client;
        }

        public void setClient(boolean client) {
            this.client = client;
        }

        public boolean isTenantCustomPoint() {
            return tenantCustomPoint;
        }

        public void setTenantCustomPoint(boolean tenantCustomPoint) {
            this.tenantCustomPoint = tenantCustomPoint;
        }

        public boolean isFieldPermission() {
            return fieldPermission;
        }

        public InitCache setFieldPermission(boolean fieldPermission) {
            this.fieldPermission = fieldPermission;
            return this;
        }

        public boolean isDocAuth() {
            return docAuth;
        }

        public InitCache setDocAuth(boolean docAuth) {
            this.docAuth = docAuth;
            return this;
        }
    }

}
