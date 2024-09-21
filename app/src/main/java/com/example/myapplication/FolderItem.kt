package com.example.myapplication

class FolderItem(id : Int, text : String, val subItems : List<Item> = emptyList()) : Item(id, text) {

}