# Fishbone Trehalose

Fishbone Trehalose is a library addressing restrictions and inconvenient. Examples include:

- Player riding.
- Get or add something composed.
- Query something composed by id/string.

## Cheatsheet

Things made player riding possible:

- Redirect `EntityType.canSerialize()` in `Entity.addPassenger(Entity)` to a custom method which returns `true`.
- Send `ClientboundSetPassengersPacket` to the vehicle player when mounting or dismounting.

Interface injections:

```java
public class ItemEnchantments {
    public int getLevel(String enchantment) {}
}
```

```java
public class Scoreboard {
    public boolean containsObjective(String name) {}

    public Objective getOrAddObjective(String name, ObjectiveCriteria criterion, Component displayName, RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat)

    public boolean containsPlayerTeam(String name) {}

    public Team getOrAddPlayerTeam(String name) {}
}
```

```java
public abstract class Entity {
    public double getX(float partialTickTime) {}

    public double getY(float partialTickTime) {}

    public double getZ(float partialTickTime) {}

    public Set<String> getTags() {}

    public boolean hasTag(String tag) {}

    public CustomData getCustomData() {}

    public CustomData getOrCreateCustomData() {}

    public void setCustomData(CustomData customData) {}
}
```

```java
public final class ItemStack {
    public CustomData getCustomData() {}

    public CustomData getOrCreateCustomData() {}

    public void setCustomData(CustomData customData) {}
}
```

```java
public class CustomBossEvents {
    public CommandBossBar getOrCreate(Identifier id, Component displayName) {}

    public boolean containsKey(Identifier id) {}

    public void remove(Identifier id) {}
}
```

```java
public class CustomData {
    public CompoundTag getTag() {}

    public CustomData merge(CustomData other) {}
}
```

```java
public final class Item {
    public Holder.Reference<Item> getRegistryHolder() {}

    public Identifier getId() {}

    public DataComponentMap getComponents() {}
}
```

```java
public abstract class Player {
    public ScoreHolder getScoreHolder() {}
}
```

```java
public abstract class LivingEntity {
    public List<Entry<Holder<Enchantment>>> getEnchantments(ResourceKey<Enchantment> key) {}

    public List<Entry<Holder<Enchantment>>> getEnchantments() {}

    public boolean isDead() {}

    public void setDead(boolean dead) {}

    public float getBodyYaw(float partialTickTime) {}

    public float getHeadYaw(float partialTickTime) {}

    public ScoreHolder getScoreHolder() {}
}
```

Utility classes:

```java
public abstract class BossEvents {
    public abstract class BossBarColors {
        public static String getName(ChatFormatting format) {}

        public static ChatFormatting getFormatting(String name) {}

        public static BossBarColor byName(String name) {}

        public static BossBarColor byFormatting(ChatFormatting format) {}
    }

    public abstract class BossBarOverlays {
        public static BossBarOverlay byName(String name) {}
    }
}
```
