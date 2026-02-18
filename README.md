# Fishbone Trehalose

Fishbone Trehalose is a library addressing restrictions and inconvenient. Examples include:

- Player riding.
- Inconsistent manipulation to `CustomData` between `Entity` and `ItemStack`.
- Lacks of `remove(String)`, `remove(Identifier)` for `Map`s in composing objects but only `remove(Object)`.
- Lacks of `getOrAdd`, `getOrCreate`, `getOrEmpty`.
- Lacks of `deepCopy` for mutable composing objects which can be composed very deep (eg. 512).
