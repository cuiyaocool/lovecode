package com.example.lovecode;

import org.junit.jupiter.api.Test;

public class EnumTest {

    public Friend addFriend(String name, boolean isgood) {
        if (isgood) {
            return new Friend(name, FriendType.GOOD);
        } else {
            return new Friend(name, FriendType.BAD);
        }
    }

    public String getNameByType(FriendType type) {
        return type.name();
    }

    public int getOrderByType(FriendType type) {
        return type.ordinal();
    }



    public class Friend {
        FriendType type;
        String name;

        public Friend(String name, FriendType type) {
            this.name = name;
            this.type = type;
        }
    }

}
