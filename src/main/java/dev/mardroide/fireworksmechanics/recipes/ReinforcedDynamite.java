package dev.mardroide.fireworksmechanics.recipes;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ReinforcedDynamite {
    public ReinforcedDynamite() {
        ItemStack dynamite = new ItemStack(Material.TNT);
        ItemMeta dynamiteMeta = dynamite.getItemMeta();
        dynamiteMeta.setDisplayName(ChatColor.YELLOW + "Reinforced dynamite");
        dynamiteMeta.addEnchant(Enchantment.LUCK, 1, false);
        dynamiteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        dynamite.setItemMeta(dynamiteMeta);

        NamespacedKey key = new NamespacedKey(FireworksMechanics.getInstance(), "reinforced_dynamite");
        ShapedRecipe reinforceRocketRecipe = new ShapedRecipe(key, dynamite);

        reinforceRocketRecipe.shape("XXX", "XYX", "XXX");
        reinforceRocketRecipe.setIngredient('X', Material.STRING);
        reinforceRocketRecipe.setIngredient('Y', Material.TNT);

        Bukkit.addRecipe(reinforceRocketRecipe);
    }
}
