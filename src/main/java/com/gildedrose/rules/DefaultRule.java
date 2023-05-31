package com.gildedrose.rules;

import com.gildedrose.Item;

public class DefaultRule implements Rule {

    private final int qualityImpact;


    private DefaultRule(
        int qualityImpact
    ) {
        this.qualityImpact = qualityImpact;
    }

    @Override
    public boolean matches(Item item) {
        return true;
    }

    @Override
    public int qualityImpact(Item item) {
        return item.quality + qualityImpact;
    }

    public static class Builder {
        private int qualityImpact;

        public Builder updateQualityBy(int amount) {
            this.qualityImpact = amount;
            return this;
        }

        public Rule build() {
            return new DefaultRule(qualityImpact);
        }
    }
}
