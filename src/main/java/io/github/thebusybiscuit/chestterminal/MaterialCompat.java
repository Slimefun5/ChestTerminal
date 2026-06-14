package io.github.thebusybiscuit.chestterminal;

import javax.annotation.Nonnull;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun5.libraries.xseries.XMaterial;

/**
 * Resolves {@link XMaterial} constants to a {@link Material} that exists on the
 * running server. Keeps ChestTerminal loadable on legacy versions (e.g. 1.8)
 * where modern constants are absent.
 *
 * @author TheBusyBiscuit
 */
final class MaterialCompat {

    private MaterialCompat() {}

    @Nonnull
    static Material safe(@Nonnull XMaterial material) {
        Material resolved = material.parseMaterial();
        return resolved != null ? resolved : Material.STONE;
    }
}
