package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.rules.DefaultRule;
import com.gildedrose.rules.Rule;
import com.gildedrose.rules.SellDateRule;
import com.gildedrose.rules.UpdateQualityRule;

import java.util.List;
import java.util.function.Predicate;

public class DefaultItem implements GildedRoseCalculator {
    private static final Predicate<Item> QUALITY_IS_BIGGER_THAN_FIFTY = item -> item.quality >= 50;
    private static final Predicate<Item> QUALITY_IS_ZERO = item -> item.quality <= 0;
    private static final Predicate<Item> SELL_IN_IS_ZERO = item -> item.sellIn <= 0;



    List<Rule> rules = List.of(
        new UpdateQualityRule.Builder().updateQualityBy(0).when(QUALITY_IS_BIGGER_THAN_FIFTY).build(),
        new UpdateQualityRule.Builder().updateQualityBy(0).when(QUALITY_IS_ZERO).build(),
        new SellDateRule.Builder().updateQualityBy(-2).when(SELL_IN_IS_ZERO).build(),
        new DefaultRule.Builder().updateQualityBy(-1).build()
    );

    @Override
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
