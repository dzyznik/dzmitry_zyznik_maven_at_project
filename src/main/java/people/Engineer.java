package people;

public abstract class Engineer extends Person{

    private int skills;
    private int experience;

    public Engineer(int age, int skills, int experience) {
        super(age);
        this.skills = skills;
        this.experience = experience;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }




}
