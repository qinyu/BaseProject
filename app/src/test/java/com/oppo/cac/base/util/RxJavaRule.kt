/*
 * Copyright 2019 JUN MAO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * imitations under the License.
 */

package com.oppo.cac.base.util

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class RxJavaRule : TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)

        RxJavaPlugins.setIoSchedulerHandler {
            Schedulers.trampoline()
        }
        RxJavaPlugins.setNewThreadSchedulerHandler {
            Schedulers.trampoline()
        }
        RxJavaPlugins.setComputationSchedulerHandler {
            Schedulers.trampoline()
        }

        RxAndroidPlugins.setMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }
    }

    override fun finished(description: Description?) {
        super.finished(description)

        RxJavaPlugins.reset()

        RxAndroidPlugins.reset()
    }
}