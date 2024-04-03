package com.example.composerecyclerview.model

data class StudentDetails(val id: Int,
                          val name: String,
                          val gender: String,
                          val age: Int,
                          val father_name: String,
                          val image: Int = 0)
