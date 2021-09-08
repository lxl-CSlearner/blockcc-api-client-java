/*
 * Copyright (c) 2020. Block.cc Inc @ https://block.cc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package cc.block.data.api.domain.news.request;

import cc.block.data.api.domain.PageableParam;

import java.util.Locale;

/**
 * @author lijiaxing
 * <p>
 * Article Request Parameter
 */

public class BriefParam extends PageableParam {

    /**
     * locale
     */
    private Locale locale;

    protected BriefParam(BriefParamBuilder<?, ?> b) {
        super(b);
        this.locale = b.locale;
    }

    public static BriefParamBuilder<?, ?> builder() {
        return new BriefParamBuilderImpl();
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String toString() {
        return "BriefParam(locale=" + this.getLocale() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BriefParam)) return false;
        final BriefParam other = (BriefParam) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$locale = this.getLocale();
        final Object other$locale = other.getLocale();
        if (this$locale == null ? other$locale != null : !this$locale.equals(other$locale)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BriefParam;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $locale = this.getLocale();
        result = result * PRIME + ($locale == null ? 43 : $locale.hashCode());
        return result;
    }

    public static abstract class BriefParamBuilder<C extends BriefParam, B extends BriefParamBuilder<C, B>> extends PageableParamBuilder<C, B> {
        private Locale locale;

        public B locale(Locale locale) {
            this.locale = locale;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "BriefParam.BriefParamBuilder(super=" + super.toString() + ", locale=" + this.locale + ")";
        }
    }

    private static final class BriefParamBuilderImpl extends BriefParamBuilder<BriefParam, BriefParamBuilderImpl> {
        private BriefParamBuilderImpl() {
        }

        protected BriefParamBuilderImpl self() {
            return this;
        }

        public BriefParam build() {
            return new BriefParam(this);
        }
    }
}
