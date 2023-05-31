package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Nested
    class TestNormalItem {
        @Test
        void testUpdateQuality_NormalItem_QualityAndSellInDecreaseByOne() {
            Item[] items = new Item[]{new Item("Normal Item", 10, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(19, items[0].quality);
        }

        @Test
        void testUpdateQuality_NormalItem_QualityAndSellInDecreaseByTwo_AfterSellInDate() {
            Item[] items = new Item[]{new Item("Normal Item", -1, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-2, items[0].sellIn);
            assertEquals(18, items[0].quality);
        }

        @Test
        void testUpdateQuality_NormalItem_QualityNeverNegative() {
            Item[] items = new Item[]{new Item("Normal Item", 10, 0)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }

    @Nested
    class TestConjuredItem {
        @Test
        void testUpdateQuality_ConjuredItem_QualityAndSellInDecreaseByOne() {
            Item[] items = new Item[]{new Item("Conjured", 10, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(18, items[0].quality);
        }

        @Test
        void testUpdateQuality_ConjuredItem_QualityAndSellInDecreaseByTwo_AfterSellInDate() {
            Item[] items = new Item[]{new Item("Conjured", -1, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-2, items[0].sellIn);
            assertEquals(16, items[0].quality);
        }

        @Test
        void testUpdateQuality_ConjuredItem_QualityNeverNegative() {
            Item[] items = new Item[]{new Item("Conjured", 10, 0)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }
    @Nested
    class TestBrie {
        @Test
        void testUpdateQuality_AgedBrie_QualityIncreases() {
            Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(21, items[0].quality);
        }

        @Test
        void testUpdateQuality_AgedBrie_QualityIncreasesByTwo_AfterSellInDate() {
            Item[] items = new Item[]{new Item("Aged Brie", -1, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-2, items[0].sellIn);
            assertEquals(22, items[0].quality);
        }

        @Test
        void testUpdateQuality_AgedBrie_QualityNeverMoreThanFifty() {
            Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }

    @Nested
    class TestSulfuras {
        @Test
        void testUpdateQuality_Sulfuras_NoChangeInQualityAndSellIn() {
            Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(10, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }
    }

    @Nested
    class TestBackStage {

        @Test
        void testUpdateQuality_BackstagePasses_QualityIncreasesByTwo_WhenSellInIsTenOrLess() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(22, items[0].quality);
        }

        @Test
        void testUpdateQuality_BackstagePasses_QualityIncreasesByOne() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(19, items[0].sellIn);
            assertEquals(31, items[0].quality);
        }

        @Test
        void testUpdateQuality_BackstagePasses_QualityIncreasesByTwo_WhenSellInLessThanEleven() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, items[0].sellIn);
            assertEquals(32, items[0].quality);
        }

        @Test
        void testUpdateQuality_BackstagePasses_QualityIncreasesByThree_WhenSellInLessThanSix() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(4, items[0].sellIn);
            assertEquals(33, items[0].quality);
        }

        @Test
        void testUpdateQuality_BackstagePasses_QualityDropsToZero_AfterSellInDate() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-1, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

    }

}
