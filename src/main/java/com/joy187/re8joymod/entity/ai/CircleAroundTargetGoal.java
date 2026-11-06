package com.joy187.re8joymod.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

public class CircleAroundTargetGoal extends Goal {
    private Mob entity;
    private LivingEntity target;
    private final float circleDistance;
    private final float circleRadius;
    private final float moveSpeed;
    private float wanderAngle = 0;

    public CircleAroundTargetGoal(Mob entity, float circleDistance, float circleRadius, float moveSpeed) {
        this.entity = entity;
        this.circleDistance = circleDistance;
        this.circleRadius = circleRadius;
        this.moveSpeed = moveSpeed;
    }

    public boolean canUse() {
//        if (entity.dis(target, circleDistance, circleDistance / 2)) {
        return entity.getTarget()!= null;
//            return target != null;
//        } else {
//            return false;
//        }
    }

    public void start() {
        wanderAngle = 0;
    }

    public void tick() {
        if (target == null) {
            return;
        }
        // 计算生物当前位置与目标的向量
        double dx = target.getX() - entity.getX();
        double dz = target.getZ() - entity.getZ();
        // 计算向量的模并将其归一化
        double distance = Mth.sqrt((float) (dx * dx + dz * dz));
        dx /= distance;
        dz /= distance;
        // 计算生物需要偏离目标的角度
        float angle = wanderAngle + 80;
        // 在偏离目标的方向上生成一段圆弧
        double x = target.getX() + circleDistance * Math.cos(Math.toRadians(angle));
        double z = target.getZ() + circleDistance * Math.sin(Math.toRadians(angle));
        // 计算生物需要转向的角度
        double yaw = Math.toDegrees(Math.atan2(z - entity.getZ(), x - entity.getX())) - 90;
        entity.setYRot((float) yaw);
        // 计算生物需要移动的速度
        entity.getMoveControl().strafe(moveSpeed,1.1f);
        entity.setSpeed(moveSpeed);
        // 更新偏离目标的角度
        wanderAngle += 3;
        // 计算新一步行走的坐标
        double nextX = entity.getX() + dx * moveSpeed;
        double nextZ = entity.getZ() + dz * moveSpeed;
        // 确认新坐标可走，否则重新计算角度
        //BlockPos nextPos = new BlockPos(nextX, entity.getY(), nextZ);
        BlockPos nextPos = entity.getOnPos();
        if (!entity.level().getBlockState(nextPos).isSolid()) {
            return;
        }
        wanderAngle += 180;
    }
}

