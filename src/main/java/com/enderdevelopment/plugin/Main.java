package com.enderdevelopment.plugin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Registry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class Main extends JavaPlugin implements CommandExecutor {
    private static final int BOOK_LEVEL = 1000;

    @Override
    public void onEnable() {
        if (getCommand("encantamentos") != null) {
            getCommand("encantamentos").setExecutor(this);
        }
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can use this command.").color(NamedTextColor.RED));
            return true;
        }

        giveAllEnchantmentBooks(player);
        giveCustomItems(player);
        player.sendMessage(Component.text("You received one level 1000 book for every enchantment and four custom items.")
                .color(NamedTextColor.GREEN));
        return true;
    }

    private void giveAllEnchantmentBooks(Player player) {
        List<Enchantment> enchantments = new ArrayList<>(Registry.ENCHANTMENT.stream().toList());
        enchantments.sort(Comparator.comparing(enchantment -> Registry.ENCHANTMENT.getKey(enchantment).asString()));

        for (Enchantment enchantment : enchantments) {
            ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
            if (meta == null) {
                continue;
            }
            meta.addStoredEnchant(enchantment, BOOK_LEVEL, true);
            book.setItemMeta(meta);
            player.getInventory().addItem(book);
        }
    }

    private void giveCustomItems(Player player) {
        player.getInventory().addItem(createEnchantedItem(
                new ItemStack(Material.STICK), Enchantment.KNOCKBACK, 1000));
        player.getInventory().addItem(createEnchantedItem(
                new ItemStack(Material.WOODEN_SHOVEL), Enchantment.FORTUNE, 1000));

        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();
        if (swordMeta != null) {
            swordMeta.addEnchant(Enchantment.SHARPNESS, 1000, true);
            swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 1000, true);
            sword.setItemMeta(swordMeta);
        }
        player.getInventory().addItem(sword);

        player.getInventory().addItem(createEnchantedItem(
                new ItemStack(Material.NETHERITE_AXE), Enchantment.FORTUNE, 101));
    }

    private ItemStack createEnchantedItem(ItemStack item, Enchantment enchantment, int level) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addEnchant(enchantment, level, true);
            item.setItemMeta(meta);
        }
        return item;
    }
}
