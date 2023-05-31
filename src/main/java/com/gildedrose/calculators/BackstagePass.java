package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.rules.*;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BackstagePass implements GildedRoseCalculator {
    private static final Predicate<Item> QUALITY_IS_BIGGER_THAN_FIFTY = item -> item.quality >= 50;
    private static final Predicate<Item> QUALITY_IS_ZERO = item -> item.quality <= 0;
    private static final Predicate<Item> SELL_IN_IS_ZERO = item -> item.sellIn < 0;
    private static final BiFunction<Integer, Integer, Predicate<Item>> SELL_IN_IS_IN_BETWEEN = (from, to) -> (item -> item.sellIn <= from && item.sellIn > to);

    List<Rule> rules = List.of(
        new UpdateQualityRule.Builder().updateQualityBy(0).when(QUALITY_IS_BIGGER_THAN_FIFTY).build(),
        new UpdateQualityRule.Builder().updateQualityBy(0).when(QUALITY_IS_ZERO).build(),
        new SellDateRule.Builder().updateQualityBy(2).when(SELL_IN_IS_IN_BETWEEN.apply(10, 5)).build(),
        new SellDateRule.Builder().updateQualityBy(3).when(SELL_IN_IS_IN_BETWEEN.apply(5, 0)).build(),
        new QualityZeroRule.Builder().when(SELL_IN_IS_ZERO).build(),
        new DefaultRule.Builder().updateQualityBy(1).build()
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
