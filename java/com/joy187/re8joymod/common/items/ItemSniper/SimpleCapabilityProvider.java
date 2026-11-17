package com.joy187.re8joymod.common.items.ItemSniper;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullFunction;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.Supplier;

public class SimpleCapabilityProvider<C> implements ICapabilityProvider {

    protected final LazyOptional<C> instance;
    protected final Set<Supplier<Capability<? super C>>> capabilities;

    @Nullable
    protected final NonNullFunction<C, ICapabilityProvider> instanceMapper;

    public SimpleCapabilityProvider(LazyOptional<C> capability,
                                    Supplier<Capability<? super C>> capabilityHolder) {
        this(capability, ImmutableSet.of(capabilityHolder));
    }

    public SimpleCapabilityProvider(LazyOptional<C> capability,
                                    Set<Supplier<Capability<? super C>>> capabilityHolder) {
        this(capability, capabilityHolder, null);
    }

    public SimpleCapabilityProvider(LazyOptional<C> instance,
                                    Set<Supplier<Capability<? super C>>> capabilities,
                                    @Nullable NonNullFunction<C, ICapabilityProvider> instanceMapper) {
        this.instance = instance;
        this.capabilities = capabilities;
        this.instanceMapper = instanceMapper;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (this.capabilities.stream().map(Supplier::get).anyMatch(cap::equals)) {
            return this.instance.cast();
        } else if (this.instanceMapper != null) {
            return this.instance
                    .lazyMap(this.instanceMapper)
                    .lazyMap(provider -> provider.getCapability(cap, side))
                    .orElse(LazyOptional.empty());
        }
        return LazyOptional.empty();
    }
}
