package com.joy187.re8joymod.common.items;

//public class ItemStoryBook extends Item {
//    public ItemStoryBook() {
//        super(new Properties()
//                .tab(RegistryEvents.RE8GROUP)
//                .stacksTo(1)
//                .rarity(Rarity.RARE)
//        );
//    }
//
//    @Override
//    public ActionResultType useOn(ItemUseContext context) {
//        if(context.getPlayer() != null) {
//            if(context.getPlayer().level.dimension() == DimensionInit.RE8_DIMENSTON_WORLD
//                    || context.getPlayer().level.dimension() == World.OVERWORLD) {
//                for(Direction direction : Direction.Plane.VERTICAL) {
//                    BlockPos framePos = context.getClickedPos().relative(direction);
//                    if(((RE8PortalBlock) ModBlocks.RE8_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
//                        context.getLevel().playSound(context.getPlayer(), framePos,
//                                SoundEvents.PORTAL_TRIGGER, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                        return ActionResultType.CONSUME;
//                    }
//                    else return ActionResultType.FAIL;
//                }
//            }
//        }
//        return ActionResultType.FAIL;
//    }

//}