package com.example.Lab9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.Lab9.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var database: BudgetPlanDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            BudgetPlanDB::class.java, "budgetplannerdb"
        ).build()
        val planDao = database.planDao()

        binding.addButton.setOnClickListener{
            val name = binding.name.text.toString()
            val amount = binding.amount.text.toString().toInt()
            val date = binding.date.text.toString()
            val budgetPlan = BudgetPlan(name = name, amount = amount, date = date)
            GlobalScope.launch {
                planDao.insertAll(budgetPlan)
            }
            Toast.makeText( applicationContext, "Plan created", Toast.LENGTH_LONG).show()
        }

        binding.getAllButton.setOnClickListener{
            GlobalScope.launch {
                val plans = planDao.getAll()
                var plansInfo = ""
                plans.forEach{
                    plansInfo += "${it.id}: ${it.name} ${it.amount} ${it.date}\n"
                }
                runOnUiThread{
                    binding.textView.text = plansInfo
                }
            }
        }

        binding.deleteButton.setOnClickListener{
            val planId = binding.idText.text.toString().toIntOrNull()

            if (planId == null || planId < 0) {
                Toast.makeText(this, "Invalid index.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                planDao.deleteById(planId)
            }
        }
    }
}

