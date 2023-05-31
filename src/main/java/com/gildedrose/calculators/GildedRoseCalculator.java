package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.rules.Rule;

import java.util.List;

import static com.gildedrose.rules.EmptyRuleRule.EMPTY_RULE;

public interface GildedRoseCalculator {

    default void updateItem(Item item) {
        updateSellIn(item);
        updateQuality(item);

    }

    default void updateQuality(Item item) {
        item.quality = getRules()
            .stream()
            .filter(rule -> rule.matches(item))
            .findFirst()
            .orElse(EMPTY_RULE)
            .qualityImpact(item);
    }

    List<Rule> getRules();

    void updateSellIn(Item item);
}
