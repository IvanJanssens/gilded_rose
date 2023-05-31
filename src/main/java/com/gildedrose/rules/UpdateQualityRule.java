package com.gildedrose.rules;

import com.gildedrose.Item;

import java.util.function.Predicate;

public class UpdateQualityRule implements Rule {

    private final int qualityImpact;

    private final Predicate<Item> predicate;

    private UpdateQualityRule(
        Predicate<Item> predicate,
        int qualityImpact
    ) {
        this.qualityImpact = qualityImpact;
        this.predicate = predicate;
    }


    @Override
    public boolean matches(Item item) {
        return predicate.test(item);
    }

    @Override
    public int qualityImpact(Item item) {
        return item.quality + qualityImpact;
    }

    public static class Builder {
        private int qualityImpact;
        private Predicate<Item> predicate;

        public Builder when(Predicate<Item> predicate) {
            this.predicate = predicate;
            return this;
        }

        public Builder updateQualityBy(int amount) {
            this.qualityImpact = amount;
            return this;
        }

        public Rule build() {
            return new UpdateQualityRule(predicate, qualityImpact);
        }
    }

}
