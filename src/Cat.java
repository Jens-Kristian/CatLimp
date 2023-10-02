class Cat {
    private String name;
    private boolean chipped;

    public Cat(String catName, boolean isChipped) {
        name = catName;
        chipped = isChipped;
    }

    public String getName() {
        return name;
    }

    public boolean isChipped() {
        return chipped;
    }

    public String toString() {
        return "Cat name: " + name + ", chipped: " + chipped;
    }
}