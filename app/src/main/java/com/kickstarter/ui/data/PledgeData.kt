package com.kickstarter.ui.data

import android.os.Parcelable
import auto.parcel.AutoParcel
import com.kickstarter.models.Reward

@AutoParcel
abstract class PledgeData : Parcelable {
    abstract fun pledgeFlowContext(): PledgeFlowContext
    abstract fun projectData(): ProjectData
    abstract fun reward(): Reward
    abstract fun screenLocation(): ScreenLocation?

    @AutoParcel.Builder
    abstract class Builder {
        abstract fun pledgeFlowContext(pledgeFlowContext: PledgeFlowContext): Builder
        abstract fun projectData(projectData: ProjectData): Builder
        abstract fun reward(reward: Reward): Builder
        abstract fun screenLocation(screenLocation: ScreenLocation?): Builder
        abstract fun build(): PledgeData
    }

    abstract fun toBuilder(): Builder

    companion object {

        fun builder(): Builder {
            return AutoParcel_PledgeData.Builder()
        }

        fun with(pledgeFlowContext: PledgeFlowContext, projectData: ProjectData, reward: Reward, screenLocation: ScreenLocation?): PledgeData {
            return PledgeData.builder()
                    .pledgeFlowContext(pledgeFlowContext)
                    .projectData(projectData)
                    .reward(reward)
                    .screenLocation(screenLocation)
                    .build()
        }

        fun with(pledgeFlowContext: PledgeFlowContext, projectData: ProjectData, reward: Reward): PledgeData {
            return with(pledgeFlowContext, projectData, reward, null)
        }
    }
}
