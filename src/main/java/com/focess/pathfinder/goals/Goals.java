package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.WrappedGoal;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class Goals {

    public static Set<NMSGoalItem> goalItems = Sets.newHashSet();

    public static List<GoalItem> getNMSGoalItem(Class<?> clz) {
        List<GoalItem> goalItems = Lists.newArrayList();
        for (NMSGoalItem goalItem : Goals.goalItems)
            if (goalItem.getGoalClass().equals(clz))
                goalItems.add(goalItem);
        if (goalItems.size() == 0)
            goalItems.add(new NMSGoalItem(clz, 0) {
                @Override
                public NMSGoalItem clear() {
                    return this;
                }

                @Override
                public WrappedGoal build(int priority,boolean isTarget) {
                    throw new UnsupportedOperationException("Unknown NMSGoal cannot be built.");
                }

                @Override
                protected void write(int i, Object object) {
                    throw new UnsupportedOperationException("Unknown NMSGoal cannot be written.");
                }
            });
        return goalItems;
    }

    public static class MOVE {
        public static final ArrowAttackGoalItem ARROW_ATTACK = new ArrowAttackGoalItem();
        public static final AvoidTargetGoalItem AVOID_TARGET = new AvoidTargetGoalItem();
        public static final AvoidTargetGoalItem_1_13 AVOID_TARGET_1_13 = new AvoidTargetGoalItem_1_13();
        public static final BowShootGoalItem_1_11 BOW_SHOOT_1_11 = new BowShootGoalItem_1_11();
        public static final BowShootGoalItem_1_9 BOW_SHOOT_1_9 = new BowShootGoalItem_1_9();
        public static final BowShootGoalItem_1_12 BOW_SHOOT_1_12 = new BowShootGoalItem_1_12();
        public static final BreathGoalItem BREATH = new BreathGoalItem();
        public static final BreedGoalItem BREED = new BreedGoalItem();
        public static final BreedGoalItem_1_11 BREED_1_11 = new BreedGoalItem_1_11();
        public static final CatSitOnBedGoalItem CAT_SIT_ON_BED = new CatSitOnBedGoalItem();
        public static final CrossbowAttackGoalItem CROSSBOW_ATTACK = new CrossbowAttackGoalItem();
        public static final EatTileGoalItem EAT_TILE = new EatTileGoalItem();
        public static final FleeSunGoalItem FLEE_SUN = new FleeSunGoalItem();
        public static final FollowEntityGoalItem FOLLOW_ENTITY = new FollowEntityGoalItem();
        public static final FollowOwnerGoalItem_1_8 FOLLOW_OWNER_1_8 = new FollowOwnerGoalItem_1_8();
        public static final FollowOwnerGoalItem_1_15 FOLLOW_OWNER_1_15 = new FollowOwnerGoalItem_1_15();
        public static final FollowOwnerParrotGoalItem FOLLOW_OWNER_PARROT = new FollowOwnerParrotGoalItem();
        public static final GotoTargetGoalItem GOTO_TARGET = new GotoTargetGoalItem();
        public static final GotoTargetGoalItem_1_13 GOTO_TARGET_1_13 = new GotoTargetGoalItem_1_13();
        public static final JumpOnBlockGoalItem JUMP_ON_BLOCK = new JumpOnBlockGoalItem();
        public static final LeapAtTargetGoalItem LEAP_AT_TARGET = new LeapAtTargetGoalItem();
        public static final LlamaFollowGoalItem LLAMA_FOLLOW = new LlamaFollowGoalItem();
        public static final MeleeAttackGoalItem MELEE_ATTACK = new MeleeAttackGoalItem();
        public static final MoveIndoorsGoalItem MOVE_INDOORS = new MoveIndoorsGoalItem();
        public static final MoveThroughVillageGoalItem_1_8 MOVE_THROUGH_VILLAGE_1_8 = new MoveThroughVillageGoalItem_1_8();
        public static final MoveThroughVillageGoalItem_1_14 MOVE_THROUGH_VILLAGE_1_14 = new MoveThroughVillageGoalItem_1_14();
        public static final MoveTowardsRestrictionGoalItem MOVE_TOWARDS_RESTRICTION = new MoveTowardsRestrictionGoalItem();
        public static final MoveTowardsTargetGoalItem MOVE_TOWARDS_TARGET = new MoveTowardsTargetGoalItem();
        public static final NearestVillageGoalItem NEAREST_VILLAGE = new NearestVillageGoalItem();
        public static final OcelotAttackGoalItem OCELOT_ATTACK_GOAL_ITEM = new OcelotAttackGoalItem();
        public static final OfferFlowerGoalItem OFFER_FLOWER = new OfferFlowerGoalItem();
        public static final PanicGoalItem PANIC = new PanicGoalItem();
        public static final PassengerCarrotStickGoalItem PASSENGER_CARROT_STICK = new PassengerCarrotStickGoalItem();
        public static final PlayGoalItem PLAY = new PlayGoalItem();
        public static final RaidGoalItem RAID = new RaidGoalItem();
        public static final RandomFlyGoalItem RANDOM_FLY = new RandomFlyGoalItem();
        public static final RandomStrollGoalItem RANDOM_STROLL = new RandomStrollGoalItem();
        public static final RandomStrollLandGoalItem RANDOM_STROLL_LAND = new RandomStrollLandGoalItem();
        public static final RandomLookaroundGoalItem RANDOM_LOOKAROUND = new RandomLookaroundGoalItem();
        public static final RandomSwimGoalItem RANDOM_SWIM = new RandomSwimGoalItem();
        public static final RemoveBlockGoalItem REMOVE_BLOCK = new RemoveBlockGoalItem();
        public static final SitGoalItem SIT = new SitGoalItem();
        public static final StrollVillageGoalItem STROLL_VILLAGE = new StrollVillageGoalItem();
        public static final SwellGoalItem SWELL_GOAL_ITEM = new SwellGoalItem();
        public static final TameGoalItem TAME = new TameGoalItem();
        public static final TemptGoalItem_1_8 TEMPT_1_8 = new TemptGoalItem_1_8();
        public static final TemptGoalItem_1_9 TEMPT_1_9 = new TemptGoalItem_1_9();
        public static final TemptGoalItem_1_12 TEMPT_1_12 = new TemptGoalItem_1_12();
        public static final TradeWithPlayerGoalItem_1_8 TRADE_WITH_PLAYER_1_8 = new TradeWithPlayerGoalItem_1_8();
        public static final TradeWithPlayerGoalItem_1_14 TRADE_WITH_PLAYER_1_14 = new TradeWithPlayerGoalItem_1_14();
        public static final WaterJumpGoalItem WATER_JUMP = new WaterJumpGoalItem();
        public static final ZombieAttackGoalItem ZOMBIE_ATTACK = new ZombieAttackGoalItem();
    }

    public static class LOOK {
        public static final ArrowAttackGoalItem ARROW_ATTACK = new ArrowAttackGoalItem();
        public static final BegGoalItem BEG = new BegGoalItem();
        public static final BowShootGoalItem_1_11 BOW_SHOOT_1_11 = new BowShootGoalItem_1_11();
        public static final BowShootGoalItem_1_9 BOW_SHOOT_1_9 = new BowShootGoalItem_1_9();
        public static final BowShootGoalItem_1_12 BOW_SHOOT_1_12 = new BowShootGoalItem_1_12();
        public static final BreathGoalItem BREATH = new BreathGoalItem();
        public static final BreedGoalItem BREED = new BreedGoalItem();
        public static final BreedGoalItem_1_11 BREED_1_11 = new BreedGoalItem_1_11();
        public static final CrossbowAttackGoalItem CROSSBOW_ATTACK = new CrossbowAttackGoalItem();
        public static final EatTileGoalItem EAT_TILE = new EatTileGoalItem();
        public static final FollowEntityGoalItem FOLLOW_ENTITY = new FollowEntityGoalItem();
        public static final FollowOwnerGoalItem_1_8 FOLLOW_OWNER_1_8 = new FollowOwnerGoalItem_1_8();
        public static final FollowOwnerGoalItem_1_15 FOLLOW_OWNER_1_15 = new FollowOwnerGoalItem_1_15();
        public static final FollowOwnerParrotGoalItem FOLLOW_OWNER_PARROT = new FollowOwnerParrotGoalItem();
        public static final InteractGoalItem INTERACT = new InteractGoalItem();
        public static final InteractVillagersGoalItem INTERACT_VILLAGERS = new InteractVillagersGoalItem();
        public static final LookAtPlayerGoalItem LOOK_AT_PLAYER = new LookAtPlayerGoalItem();
        public static final LookAtTradingPlayerGoalItem_1_8 LOOK_AT_TRADING_PLAYER_1_8 = new LookAtTradingPlayerGoalItem_1_8();
        public static final LookAtTradingPlayerGoalItem_1_14 LOOK_AT_TRADING_PLAYER_1_14 = new LookAtTradingPlayerGoalItem_1_14();
        public static final MakeLoveGoalItem MAKE_LOVE = new MakeLoveGoalItem();
        public static final MeleeAttackGoalItem MELEE_ATTACK = new MeleeAttackGoalItem();
        public static final OcelotAttackGoalItem OCELOT_ATTACK_GOAL_ITEM = new OcelotAttackGoalItem();
        public static final OfferFlowerGoalItem OFFER_FLOWER = new OfferFlowerGoalItem();
        public static final PassengerCarrotStickGoalItem PASSENGER_CARROT_STICK = new PassengerCarrotStickGoalItem();
        public static final RandomLookaroundGoalItem RANDOM_LOOKAROUND = new RandomLookaroundGoalItem();
        public static final TemptGoalItem_1_8 TEMPT_1_8 = new TemptGoalItem_1_8();
        public static final TemptGoalItem_1_9 TEMPT_1_9 = new TemptGoalItem_1_9();
        public static final TemptGoalItem_1_12 TEMPT_1_12 = new TemptGoalItem_1_12();
        public static final ZombieAttackGoalItem ZOMBIE_ATTACK = new ZombieAttackGoalItem();
    }

    public static class JUMP {
        public static final CatSitOnBedGoalItem CAT_SIT_ON_BED = new CatSitOnBedGoalItem();
        public static final EatTileGoalItem EAT_TILE = new EatTileGoalItem();
        public static final FloatGoalItem FLOAT = new FloatGoalItem();
        public static final GotoTargetGoalItem GOTO_TARGET = new GotoTargetGoalItem();
        public static final GotoTargetGoalItem_1_13 GOTO_TARGET_1_13 = new GotoTargetGoalItem_1_13();
        public static final JumpOnBlockGoalItem JUMP_ON_BLOCK = new JumpOnBlockGoalItem();
        public static final LeapAtTargetGoalItem LEAP_AT_TARGET = new LeapAtTargetGoalItem();
        public static final PassengerCarrotStickGoalItem PASSENGER_CARROT_STICK = new PassengerCarrotStickGoalItem();
        public static final RemoveBlockGoalItem REMOVE_BLOCK = new RemoveBlockGoalItem();
        public static final SitGoalItem SIT = new SitGoalItem();
        public static final TradeWithPlayerGoalItem_1_8 TRADE_WITH_PLAYER_1_8 = new TradeWithPlayerGoalItem_1_8();
        public static final TradeWithPlayerGoalItem_1_14 TRADE_WITH_PLAYER_1_14 = new TradeWithPlayerGoalItem_1_14();
        public static final WaterJumpGoalItem WATER_JUMP = new WaterJumpGoalItem();
    }

    public static class TARGET {
        public static final DefendVillageGoalItem DEFEND_VILLAGE = new DefendVillageGoalItem();
        public static final HurtByTargetGoalItem_1_8 HURT_BY_TARGET_1_8 = new HurtByTargetGoalItem_1_8();
        public static final HurtByTargetGoalItem_1_14 HURT_BY_TARGET_1_14 = new HurtByTargetGoalItem_1_14();
        public static final NearestAttackableTargetGoalItem NEAREST_ATTACKABLE_TARGET = new NearestAttackableTargetGoalItem();
        public static final NearestAttackableTargetWitchGoalItem NEAREST_ATTACKABLE_TARGET_WITCH = new NearestAttackableTargetWitchGoalItem();
        public static final NearestHealableRaiderGoalItem NEAREST_HEALABLE_RAIDER = new NearestHealableRaiderGoalItem();
        public static final OwnerHurtByTargetGoalItem OWNER_HURT_BY_TARGET = new OwnerHurtByTargetGoalItem();
        public static final OwnerHurtTargetGoalItem OWNER_HURT_TARGET = new OwnerHurtTargetGoalItem();
        public static final RandomTargetNonTamedGoalItem RANDOM_TARGET_NON_TAMED = new RandomTargetNonTamedGoalItem();
    }
    //these goals are not complete or outdated. do not use them...
    public static final BreakDoorGoalItem_1_8 BREAK_DOOR_1_8 = new BreakDoorGoalItem_1_8();
    public static final BreakDoorGoalItem_1_14 BREAK_DOOR_1_14 = new BreakDoorGoalItem_1_14();
    public static final DoorOpenGoalItem DOOR_OPEN = new DoorOpenGoalItem();
    public static final FishSchoolGoalItem FISH_SCHOOL = new FishSchoolGoalItem();
    public static final FollowBoatGoalItem FOLLOW_BOAT = new FollowBoatGoalItem();
    public static final FollowParentGoalItem FOLLOW_PARENT = new FollowParentGoalItem();
    public static final HorseTrapGoalItem_1_9 HORSE_TRAP_1_9 = new HorseTrapGoalItem_1_9();
    public static final HorseTrapGoalItem_1_11 HORSE_TRAP_1_11 = new HorseTrapGoalItem_1_11();
    public static final NearestAttackableTargetInsentientGoalItem NEAREST_ATTACKABLE_TARGET_INSENTIENT = new NearestAttackableTargetInsentientGoalItem();
    public static final OpenDoorGoalItem OPEN_DOOR = new OpenDoorGoalItem();
    public static final PerchGoalItem PERCH = new PerchGoalItem();
    public static final RestrictOpenDoorGoalItem RESTRICT_OPEN_DOOR = new RestrictOpenDoorGoalItem();
    public static final RestrictSunGoalItem RESTRICT_SUN = new RestrictSunGoalItem();
    public static final TargetGoalItem TARGET = new TargetGoalItem();
    public static final UseItemGoalItem USE_ITEM = new UseItemGoalItem();
    public static final WaterGoalItem WATER = new WaterGoalItem();

}
