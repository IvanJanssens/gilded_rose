package com.gildedrose.calculators;

import com.gildedrose.Item;

import java.util.Map;

public class GildedRoseCalculatorFactory {

    private GildedRoseCalculatorFactory(){}

    private static final Map<String, GildedRoseCalculator> calculators = Map.of(
        "Aged Brie", new AgedBrie(),
        "Backstage passes to a TAFKAL80ETC concert", new BackstagePass(),
        "Sulfuras, Hand of Ragnaros", new Sulfuras(),
        "Conjured", new Conjured()
    );

    private static final GildedRoseCalculator defaultCalculator = new DefaultItem();

    public static GildedRoseCalculator getCalculator(Item item) {
        return calculators.getOrDefault(item.name, defaultCalculator);
    }
}
