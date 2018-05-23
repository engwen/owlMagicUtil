package com.owl.magicUtil.model;

import java.util.List;

/**
 * 後臺數據庫的菜單類
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/04/19.
 */
public abstract class MenuBase extends MsgResult {
    //菜單的ID
    private Long menuId;
    //菜單名稱
    private String menuName;
    //菜單對應的後臺地址
    private String menuAction;
    //上一級菜單，無則默認為0
    private Long parentId;
    //圖標
    private String menuIcon;
    //所處位置排行
    private Integer menuOrder;
    //可以見到菜單的角色，使用英文逗號隔開
    private String menuRole;
    //子菜單
    private List<MenuBase> menuList;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(String menuAction) {
        this.menuAction = menuAction;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuRole() {
        return menuRole;
    }

    public void setMenuRole(String menuRole) {
        this.menuRole = menuRole;
    }

    public List<MenuBase> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuBase> menuList) {
        this.menuList = menuList;
    }
}
