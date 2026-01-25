package id.banking.accountservice.constant;

public enum AccountStatusConstant {


    ACTIVE(1, "Active"),
    BLOCKED(2, "Blocked"),
    CLOSE(3, "Closed"),
    DORMANT(4, "Dormant");


    private final int status;
    private final String description;

    AccountStatusConstant(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDescription() {
        return description;
    }

    public static AccountStatusConstant getByStatusCode(int status) {
        if (AccountStatusConstant.ACTIVE.getStatus() == status) {
            return AccountStatusConstant.ACTIVE;
        } else if (AccountStatusConstant.BLOCKED.getStatus() == status) {
            return AccountStatusConstant.BLOCKED;
        } else if (AccountStatusConstant.CLOSE.getStatus() == status) {
            return AccountStatusConstant.CLOSE;
        } else if (AccountStatusConstant.DORMANT.getStatus() == status) {
            return AccountStatusConstant.DORMANT;
        }
            return null;
    }
}
