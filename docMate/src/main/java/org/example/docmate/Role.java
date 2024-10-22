package org.example.docmate;

public class Role {
    private String roleName;
    private int roleValue;

    public Role(String roleName, int roleValue) {
        this.roleName = roleName;
        this.roleValue = roleValue;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(int roleValue) {
        this.roleValue = roleValue;
    }
}
