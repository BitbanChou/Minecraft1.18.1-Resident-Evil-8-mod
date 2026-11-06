# 传送玩家到目标维度
execute in re8joymod:re8_dimension run tp @s ~ ~ ~

# 设置冷却时间
scoreboard players set @s re8portals_cooldown 300

# 移除强制加载区域
execute in re8joymod:re8_dimension run forceload remove ~5 ~5 ~-5 ~-5
execute in minecraft:overworld run forceload remove ~5 ~5 ~-5 ~-5