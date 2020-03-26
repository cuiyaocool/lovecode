package com.example.lovecode;

public enum FriendType {
    GOOD{
        @Override
        public void howToStudy() {
            System.out.println("study hard");
        }
    },
    BAD{
        @Override
        public void howToStudy() {
            System.out.println("study not hard");
        }
    };

    public abstract void howToStudy();

    public void friendStudy(String typeName) {
        if (typeName == "GOOD") {
            FriendType.GOOD.howToStudy();
        }
        else {
            FriendType.BAD.howToStudy();
        }
        FriendType.valueOf(typeName).howToStudy();
    }


}
