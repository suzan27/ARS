package com.mycompany.ars.appMenu;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import com.mycompany.ars.menuManagement.ApplicationMenu;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author bikesh
 */
@Named
@RequestScoped
public class UserMenuBean {

    private MenuModel menuModel;
    private List<ApplicationMenu> menus;


    @PostConstruct
    private void init() {
        this.menuModel = new DefaultMenuModel();
        this.menus = new ArrayList<>();
        this.addTopLevelMenu();
        this.initializeMenu();

    }

    private void initializeMenu() {
        List<ApplicationMenu> topLevelMenus = this.findAllTopLevelApplicationMenu(ApplicationMenu.MenuType.Root);
        for (ApplicationMenu app : topLevelMenus) {
            DefaultSubMenu rootLevelMenu = new DefaultSubMenu(app.getLabel());
            rootLevelMenu.setStyle("border: none;");

            //For Parameter
//            DefaultSubMenu parameterSubMenu = new DefaultSubMenu("Settings");
//            rootLevelMenu.addElement(parameterSubMenu);
//            List<ApplicationMenu> parameter_menus = this.findApplicationMenuByTypeAndParenCode(ApplicationMenu.MenuType.Parameters, app.getCode());
//            for (ApplicationMenu menu : parameter_menus) {
//                //logger.info(menu.toString());
//                parameterSubMenu.addElement(new DefaultMenuItem(menu.getLabel(), "ui-icon-wrench", menu.getUrl()));
//            }

            //For entries
            DefaultSubMenu entriesSubMenu = new DefaultSubMenu("Entries");
            rootLevelMenu.addElement(entriesSubMenu);
            List<ApplicationMenu> entries_menus = this.findApplicationMenuByTypeAndParenCode(ApplicationMenu.MenuType.Entries, app.getCode());
            for (ApplicationMenu menu : entries_menus) {
               // logger.info(menu.toString());
                entriesSubMenu.addElement(new DefaultMenuItem(menu.getLabel(), "ui-icon-pencil", menu.getUrl()));
            }

            //For queries           
//            DefaultSubMenu queriesSubMenu = new DefaultSubMenu("Queries");
//            rootLevelMenu.addElement(queriesSubMenu);
//            List<ApplicationMenu> queries_menus = this.findApplicationMenuByTypeAndParenCode(ApplicationMenu.MenuType.Queries, app.getCode());
//            for (ApplicationMenu menu : queries_menus) {
//                //logger.info(menu.toString());
//                queriesSubMenu.addElement(new DefaultMenuItem(menu.getLabel(), "ui-icon-help", menu.getUrl()));
//            }

            //For Verifications
//            DefaultSubMenu verificationSubMenu = new DefaultSubMenu("Verifications");
//            rootLevelMenu.addElement(verificationSubMenu);
//            List<ApplicationMenu> verification_menus = this.findApplicationMenuByTypeAndParenCode(ApplicationMenu.MenuType.Verifications, app.getCode());
//            for (ApplicationMenu menu : verification_menus) {
//                //logger.info(menu.toString());
//                verificationSubMenu.addElement(new DefaultMenuItem(menu.getLabel(), "ui-icon-help", menu.getUrl()));
//            }
            this.menuModel.addElement(rootLevelMenu);
        }
    }

    private void addTopLevelMenu() {
        String[] menu_codes = {"User", "Flight", "Others"};
        String[] menu_levels = {"User Management", "Flight Management", "Others"};
        int index = 0;
        for (String s : menu_codes) {
            this.menus.add(new ApplicationMenu(s, menu_levels[index], null));
            index++;
        }
        this.addSubMenu(menu_codes);
    }

    private void addSubMenu(String[] menu_codes) {
        this.addUserStructure(menu_codes[0]);
        this.addFlightStructure(menu_codes[1]);
        this.addOtherStructure(menu_codes[2]);
    }

    private void addUserStructure(String parentCode) {

        this.menus.add(new ApplicationMenu("user_manage", "Add User", parentCode, "/protected/users/user_add.xhtml", " ", ApplicationMenu.MenuType.Entries));

    }

    private void addFlightStructure(String parentCode) {
        this.menus.add(new ApplicationMenu("branch_manage", "Add Branch", parentCode, "/protected/flight/list.xhtml", " ", ApplicationMenu.MenuType.Entries));

    }

    private void addOtherStructure(String parentCode) {
    }

    private List<ApplicationMenu> findApplicationMenuByTypeAndParenCode(ApplicationMenu.MenuType menuType, String parentCode) {
        List<ApplicationMenu> filteredMenus = new ArrayList<>();
        for (ApplicationMenu menu : this.menus) {
            if (menu.getMenuType() == menuType && StringUtils.equals(menu.getParentCode(), parentCode)) {
                filteredMenus.add(menu);
            }

        }
        return filteredMenus;
    }

    private List<ApplicationMenu> findAllTopLevelApplicationMenu(ApplicationMenu.MenuType menuType) {
        List<ApplicationMenu> filteredMenus = new ArrayList<>();
        for (ApplicationMenu menu : this.menus) {
            if (menu.getMenuType() == menuType) {
                filteredMenus.add(menu);
            }
        }
        return filteredMenus;
    }

    public MenuModel getMenuModel() {
        //logger.info("Inside getMenuModel");
        return menuModel;
    }

    public List<ApplicationMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<ApplicationMenu> menus) {
        this.menus = menus;
    }

}
