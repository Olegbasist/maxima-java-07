package org.example.model;


public class Cat {

    private Long id;
    private String name;
    private int weight;
    private boolean isAngry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IncorrectCatWeightException {

        if (weight < 0){
            throw new IncorrectCatWeightException("Покорми котика! Путь он весит хоть сколько-нибудь.");
        }
        if (weight > 30){
            throw new IncorrectCatWeightException("Пожалей котика! Он слишком тяжелый.");
        }

        this.weight = weight;
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    public Cat(Long id, String name, int weight, boolean isAngry) throws IncorrectCatWeightException {
        this.id = id;
        this.name = name;
        setWeight(weight);
        this.isAngry = isAngry;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", isAngry=" + isAngry +
                '}';
    }
}
