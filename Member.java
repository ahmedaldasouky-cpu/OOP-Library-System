import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private int maxAllowed;
    private List<LibraryItem> borrowedItems;

    public Member(String memberId, String name, int maxAllowed) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be empty.");
        }
        setName(name);
        setMaxAllowed(maxAllowed);
        this.memberId = memberId.trim();
        this.borrowedItems = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setMaxAllowed(int maxAllowed) {
        if (maxAllowed <= 0) {
            throw new IllegalArgumentException(
                "Maximum allowed must be positive."
            );
        }
        this.maxAllowed = maxAllowed;
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public boolean canBorrowMore() {
        return borrowedItems.size() < maxAllowed;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public boolean hasBorrowedItem(String itemId) {
        for (LibraryItem item : borrowedItems) {
            if (item.getId().equals(itemId)) {
                return true;
            }
        }
        return false;
    }
}
