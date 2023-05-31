package com.gildedrose.rules;

import com.gildedrose.Item;

public class EmptyRuleRule implements Rule {

    public static final Rule EMPTY_RULE = new EmptyRuleRule();

    @Override
    public boolean matches(Item item) {
        return true;
    }

    @Override
    public int qualityImpact(Item item) {
        return item.quality;
    }
}
