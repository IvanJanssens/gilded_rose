package com.gildedrose.rules;

import com.gildedrose.Item;

import java.util.function.Predicate;

public class QualityZeroRule implements Rule {

    private final Predicate<Item> predicate;

    private QualityZeroRule(
        Predicate<Item> predicate
    ) {
        this.predicate = predicate;
    }

    @Override
    public boolean matches(Item item) {
        return predicate.test(item);
    }

    @Override
    public int qualityImpact(Item item) {
        return 0;
    }

    public static class Builder {
        private Predicate<Item> predicate;

        public Builder when(Predicate<Item> predicate) {
            this.predicate = predicate;
            return this;
        }

        public Rule build() {
            return new QualityZeroRule(predicate);
        }
    }
}
