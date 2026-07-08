package io.github.thebusybiscuit.chestterminal;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

import io.github.thebusybiscuit.chestterminal.items.AccessTerminal;
import io.github.thebusybiscuit.chestterminal.items.ExportBus;
import io.github.thebusybiscuit.chestterminal.items.ImportBus;
import io.github.thebusybiscuit.chestterminal.items.MilkyQuartz;
import io.github.thebusybiscuit.chestterminal.items.WirelessTerminal;
import io.github.thebusybiscuit.slimefun5.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun5.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun5.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun5.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun5.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun5.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun5.libraries.xseries.XMaterial;
import io.github.thebusybiscuit.slimefun5.core.guide.wiki.WikiText;
import io.github.thebusybiscuit.slimefun5.core.guide.wiki.WikiTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ChestTerminal is a Slimefun addon that adds a chest terminal system,
 * inspired by Applied Energistics. It allows remote access to items
 * stored in a Cargo network.
 *
 * @author TheBusyBiscuit
 */
public class ChestTerminal extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        new Metrics(this, 5503);

        // Setting up bStats
        
        SlimefunItemStack milkyQuartz = new SlimefunItemStack("MILKY_QUARTZ", MaterialCompat.safe(XMaterial.QUARTZ));
        SlimefunItemStack ctPanel = new SlimefunItemStack("CT_PANEL", "7a44ff3a5f49c69cab676bad8d98a063fa78cfa61916fdef3e267557fec18283");

        SlimefunItemStack chestTerminal = new SlimefunItemStack("CHEST_TERMINAL", "7a44ff3a5f49c69cab676bad8d98a063fa78cfa61916fdef3e267557fec18283");
        SlimefunItemStack importBus = new SlimefunItemStack("CT_IMPORT_BUS", "113db2e7e72ea4432eefbd6e58a85eaa2423f83e642ca41abc6a9317757b889");
        SlimefunItemStack exportBus = new SlimefunItemStack("CT_EXPORT_BUS", "113db2e7e72ea4432eefbd6e58a85eaa2423f83e642ca41abc6a9317757b889");

        SlimefunItemStack wirelessTerminal16 = new SlimefunItemStack("CT_WIRELESS_ACCESS_TERMINAL_16", MaterialCompat.safe(XMaterial.ITEM_FRAME));
        SlimefunItemStack wirelessTerminal64 = new SlimefunItemStack("CT_WIRELESS_ACCESS_TERMINAL_64", MaterialCompat.safe(XMaterial.ITEM_FRAME));
        SlimefunItemStack wirelessTerminal128 = new SlimefunItemStack("CT_WIRELESS_ACCESS_TERMINAL_128", MaterialCompat.safe(XMaterial.ITEM_FRAME));
        SlimefunItemStack wirelessTerminalTransdimensional = new SlimefunItemStack("CT_WIRELESS_ACCESS_TERMINAL_TRANSDIMENSIONAL", MaterialCompat.safe(XMaterial.ITEM_FRAME));

        ItemGroup itemGroup = new ItemGroup(new io.github.thebusybiscuit.slimefun5.libraries.keys.NamespacedKey("chestterminal", "chest_terminal"), CustomItemStack.create(chestTerminal.item(), "&5Chest Terminal", "", "&a> Click to open"));
        itemGroup.setTheme("logistics");

        new SlimefunItem(itemGroup, milkyQuartz, RecipeType.GEO_MINER,
                new ItemStack[0])
                .register(this);

        new SlimefunItem(itemGroup, ctPanel, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {milkyQuartz.item(), SlimefunItems.BLISTERING_INGOT_3.item(), milkyQuartz.item(), SlimefunItems.REDSTONE_ALLOY.item(), SlimefunItems.POWER_CRYSTAL.item(), SlimefunItems.REDSTONE_ALLOY.item(), milkyQuartz.item(), SlimefunItems.BLISTERING_INGOT_3.item(), milkyQuartz.item()})
                .register(this);

        new AccessTerminal(itemGroup, chestTerminal, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {milkyQuartz.item(), SlimefunItems.GPS_TRANSMITTER_3.item(), milkyQuartz.item(), SlimefunItems.POWER_CRYSTAL.item(), ctPanel.item(), SlimefunItems.POWER_CRYSTAL.item(), SlimefunItems.PLASTIC_SHEET.item(), SlimefunItems.ENERGY_REGULATOR.item(), SlimefunItems.PLASTIC_SHEET.item()})
                .register(this);

        new ImportBus(itemGroup, importBus, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {SlimefunItems.REDSTONE_ALLOY.item(), SlimefunItems.POWER_CRYSTAL.item(), SlimefunItems.REDSTONE_ALLOY.item(), SlimefunItems.HARDENED_METAL_INGOT.item(), SlimefunItems.CARGO_INPUT_NODE.item(), SlimefunItems.HARDENED_METAL_INGOT.item(), SlimefunItems.PLASTIC_SHEET.item(), SlimefunItems.CARGO_MOTOR.item(), SlimefunItems.PLASTIC_SHEET.item()})
                .register(this);

        new ExportBus(itemGroup, exportBus, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {null, SlimefunItems.DAMASCUS_STEEL_INGOT.item(), null, SlimefunItems.ALUMINUM_BRONZE_INGOT.item(), importBus.item(), SlimefunItems.ALUMINUM_BRONZE_INGOT.item(), SlimefunItems.PLASTIC_SHEET.item(), SlimefunItems.GOLD_10K.item(), SlimefunItems.PLASTIC_SHEET.item()})
                .register(this);

        new WirelessTerminal(itemGroup, wirelessTerminal16, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {milkyQuartz.item(), SlimefunItems.GPS_TRANSMITTER.item(), milkyQuartz.item(), SlimefunItems.COBALT_INGOT.item(), chestTerminal.item(), SlimefunItems.COBALT_INGOT.item(), SlimefunItems.BATTERY.item(), SlimefunItems.ELECTRIC_MOTOR.item(), SlimefunItems.BATTERY.item()}) {

            @Override
            public int getRange() {
                return 16;
            }

            @Override
            public float getMaxItemCharge(ItemStack item) {
                return 10;
            }

        }.register(this);

        new WirelessTerminal(itemGroup, wirelessTerminal64, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {milkyQuartz.item(), SlimefunItems.GPS_TRANSMITTER.item(), milkyQuartz.item(), SlimefunItems.COBALT_INGOT.item(), wirelessTerminal16.item(), SlimefunItems.COBALT_INGOT.item(), SlimefunItems.BATTERY.item(), SlimefunItems.ELECTRIC_MOTOR.item(), SlimefunItems.BATTERY.item()}) {

            @Override
            public int getRange() {
                return 64;
            }

            @Override
            public float getMaxItemCharge(ItemStack item) {
                return 25;
            }

        }.register(this);

        new WirelessTerminal(itemGroup, wirelessTerminal128, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {milkyQuartz.item(), SlimefunItems.GPS_TRANSMITTER_2.item(), milkyQuartz.item(), SlimefunItems.COBALT_INGOT.item(), wirelessTerminal64.item(), SlimefunItems.COBALT_INGOT.item(), SlimefunItems.BATTERY.item(), SlimefunItems.ELECTRIC_MOTOR.item(), SlimefunItems.BATTERY.item()}) {

            @Override
            public int getRange() {
                return 128;
            }

            @Override
            public float getMaxItemCharge(ItemStack item) {
                return 50;
            }

        }.register(this);

        new WirelessTerminal(itemGroup, wirelessTerminalTransdimensional, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {milkyQuartz.item(), SlimefunItems.GPS_TRANSMITTER_4.item(), milkyQuartz.item(), SlimefunItems.COBALT_INGOT.item(), wirelessTerminal128.item(), SlimefunItems.COBALT_INGOT.item(), SlimefunItems.BATTERY.item(), SlimefunItems.BLISTERING_INGOT_3.item(), SlimefunItems.BATTERY.item()}) {

            @Override
            public int getRange() {
                return -1;
            }

            @Override
            public float getMaxItemCharge(ItemStack item) {
                return 50;
            }

        }.register(this);

        new MilkyQuartz(this, milkyQuartz.item()).register();

        // Contribute this addon's per-language item translations (languages/<lang>/items.yml).
        Slimefun.getItemTranslationService().registerTranslations(this);

        // Register this addon's own in-game wiki page (core does not auto-generate addon wikis).
        registerWiki();
    }

    private void registerWiki() {
        WikiText wiki = Slimefun.getWikiText();
        String topicId = "addon_chestterminal";

        wiki.registerTopic(new WikiTopic(topicId, "Chest Terminal", XMaterial.CHEST, "&7Remote access to your cargo"));

        // Detailed authored description of the cargo-terminal system.
        wiki.setMechanic(topicId, Arrays.asList(
            "&3&lThe Cargo Terminal System", "",
            "&7ChestTerminal turns an ordinary cargo", "&7network into a searchable, remotely",
            "&7accessible storage system - much like", "&7Applied Energistics in vanilla-style Slimefun.", "",
            "&e&lHow it works", "",
            "&71. Build a &bCargo Network &7with a Cargo Manager,",
            "&7   connectors and storage containers, just like usual.",
            "&72. Tune the cargo nodes feeding your chests", "&7   into the &bChestTerminal channel&7.",
            "&73. Place a &bCT Access Terminal &7anywhere on", "&7   that same network.",
            "&74. Open the terminal to browse &eevery item", "&7   on the channel and click to withdraw it.", "",
            "&e&lMoving items automatically", "",
            "&7Use a &bCT Import Bus &7to feed items from", "&7an attached inventory into the channel, and a",
            "&7&bCT Export Bus &7to pull items back out of the", "&7channel into a target inventory - both support",
            "&7whitelist/blacklist filters.", "",
            "&e&lAccessing it remotely", "",
            "&7A &bCT Wireless Access Terminal &7links to a", "&7placed Access Terminal and opens it from a",
            "&7distance, draining energy on each use. Higher", "&7tiers reach further; the Transdimensional",
            "&7variant works across worlds with unlimited range.", "",
            "&7Click an item below for its recipe and details."));

        // Collect this addon's own items dynamically - never hardcode item lists.
        List<String> items = new ArrayList<>();

        for (SlimefunItem item : Slimefun.getRegistry().getEnabledSlimefunItems()) {
            try {
                if (item.getAddon() == this) {
                    items.add(item.getId());
                }
            } catch (Exception | LinkageError ignored) {
                // A broken item should not break wiki registration.
            }
        }

        wiki.setTopicItems(topicId, items);

        // Authored per-item explanation pages.
        registerItemPages(wiki);
    }

    private void registerItemPages(@Nonnull WikiText wiki) {
        wiki.set("MILKY_QUARTZ", Arrays.asList(
            "&7A pale variant of Nether Quartz and the", "&7foundational crafting component for this addon.", "",
            "&7Mine it with a &bGEO-Miner&7: it is most", "&7abundant in the &cNether&7, scarcer in the",
            "&7Overworld, and cannot be found in the &5End&7.", "",
            "&7Used to craft the CT Illuminated Panel,", "&7Access Terminal and every Wireless Terminal."));

        wiki.set("CT_PANEL", Arrays.asList(
            "&7The &3CT Illuminated Panel&7, a crafting", "&7component built from Milky Quartz, Blistering",
            "&7Ingots, Redstone Alloy and a Power Crystal.", "",
            "&7It forms the screen of the &bCT Access Terminal", "&7and has no function on its own - keep a few",
            "&7handy when building terminals."));

        wiki.set("CHEST_TERMINAL", Arrays.asList(
            "&7The heart of the system. Place it on a", "&7&bCargo Network &7and it lets you remotely",
            "&7browse and withdraw any item supplied by", "&7nodes tuned to the &bChestTerminal channel&7.", "",
            "&7Open it to see a paged list of every available", "&7item; click a stack to pull it into your inventory.", "",
            "&cIf it shows \"No Cargo Net connected!\" the", "&7block is not part of a working cargo network yet."));

        wiki.set("CT_IMPORT_BUS", Arrays.asList(
            "&7Attach this to an inventory on a &bCargo", "&7Network&7. It continuously pulls items out of",
            "&7that inventory and pushes them into the", "&7&bChestTerminal channel&7.", "",
            "&7Configure a &fWhitelist/Blacklist&7 filter, and", "&7toggle whether durability and lore must match,",
            "&7so only the items you choose get imported."));

        wiki.set("CT_EXPORT_BUS", Arrays.asList(
            "&7The mirror image of the Import Bus. Attach it", "&7to an inventory and it pulls items &eout&7 of",
            "&7the &bChestTerminal channel &7and deposits them", "&7into that attached inventory.", "",
            "&7Use the &fWhitelist &7filter to define exactly", "&7which items it should keep stocked - great for",
            "&7auto-feeding machines from central storage."));

        List<String> wireless16 = Arrays.asList(
            "&7A handheld terminal that links to a placed", "&7&bCT Access Terminal &7and opens it from afar.", "",
            "&8⇨ &7Range: &e16 Blocks", "&8⇨ &7Energy buffer: &e10 J &7(0.5 J per use)", "",
            "&7&eRight Click an Access Terminal &7to link it,", "&7then &eRight Click &7anywhere to open it remotely.", "",
            "&7Must be charged in an Energy Network; opening", "&7out of range or out of charge fails.");
        wiki.set("CT_WIRELESS_ACCESS_TERMINAL_16", wireless16);

        wiki.set("CT_WIRELESS_ACCESS_TERMINAL_64", Arrays.asList(
            "&7An upgraded Wireless Access Terminal with a", "&7larger range and energy buffer.", "",
            "&8⇨ &7Range: &e64 Blocks", "&8⇨ &7Energy buffer: &e25 J &7(0.5 J per use)", "",
            "&7Links to and opens a placed Access Terminal", "&7exactly like the 16-block model, just further away."));

        wiki.set("CT_WIRELESS_ACCESS_TERMINAL_128", Arrays.asList(
            "&7A high-tier Wireless Access Terminal for", "&7accessing storage across a large base.", "",
            "&8⇨ &7Range: &e128 Blocks", "&8⇨ &7Energy buffer: &e50 J &7(0.5 J per use)", "",
            "&7Built on the 64-block model with a more", "&7powerful GPS Transmitter for the extended reach."));

        wiki.set("CT_WIRELESS_ACCESS_TERMINAL_TRANSDIMENSIONAL", Arrays.asList(
            "&7The ultimate Wireless Access Terminal.", "",
            "&8⇨ &7Range: &eUnlimited", "&8⇨ &7Energy buffer: &e50 J &7(0.5 J per use)", "",
            "&7Ignores distance entirely and works &dacross", "&7&dworlds &7- open a linked Access Terminal from",
            "&7anywhere, even another dimension, as long as", "&7it still has charge."));
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nonnull
    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Slimefun5/ChestTerminal/issues";
    }
}

