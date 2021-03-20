package thevoid.whichbinds.composecodelab.codelab03


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import thevoid.whichbinds.composecodelab.codelab03.domain.TodoItem

class TodoViewModel : ViewModel() {

    // remove the LiveData and replace it with a mutableStateOf
    //private var _todoItems = MutableLiveData(listOf<TodoItem>())
    //val todoItems: LiveData<List<TodoItem>> = _todoItems

    // private state
    private var currentEditPosition by mutableStateOf(-1)

    // state
    var todoItems: List<TodoItem> by mutableStateOf(listOf())
        private set

    // state
    val currentEditItem: TodoItem?
        get() = todoItems.getOrNull(currentEditPosition)

    // event: onEditItemSelected
    fun onEditItemSelected(item: TodoItem) {
        currentEditPosition = todoItems.indexOf(item)
    }

    // event: onEditDone
    fun onEditDone() {
        currentEditPosition = -1
    }

    // event: onEditItemChange
    fun onEditItemChange(item: TodoItem) {
        val currentItem = requireNotNull(currentEditItem)
        require(currentItem.id == item.id) {
            "You can only change an item with the same id as currentEditItem"
        }

        todoItems = todoItems.toMutableList().also {
            it[currentEditPosition] = item
        }
    }

    // event: addItem
    fun addItem(item: TodoItem) {
        todoItems = todoItems + listOf(item)
    }

    // event: removeItem
    fun removeItem(item: TodoItem) {
        // toMutableList makes a mutable copy of the list we can edit, then
        // assign the new list to todoItems (which is still an immutable list)
        todoItems = todoItems.toMutableList().also {
            it.remove(item)
        }
        onEditDone() // don't keep the editor open when removing items
    }
}