package com.example.Lab9

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [BudgetPlan::class], version = 1)
abstract class BudgetPlanDB: RoomDatabase() {
    abstract fun planDao(): BudgetPlanDao
}

@Entity(tableName = "plans")
data class BudgetPlan(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "amount") val amount: Int?,
    @ColumnInfo(name = "date") val date: String?
)

@Dao
interface BudgetPlanDao {
    @Query("SELECT * FROM plans")
    fun getAll(): List<BudgetPlan>

    @Insert
    fun insertAll(vararg budgetPlans: BudgetPlan)

    @Delete
    fun delete (budgetPlan: BudgetPlan)

    @Query("DELETE FROM plans WHERE id = :budgetPlanId")
    fun deleteById(budgetPlanId: Int)
}
