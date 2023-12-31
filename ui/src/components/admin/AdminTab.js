import React from 'react';
import {Tab} from 'semantic-ui-react';
import {UserTable} from './UserTable';
import {OrderTable} from './OrderTable';
import {EditOrderTable} from './EditOrderTable';
import { WorkersTable } from './WorkersTable';
import { ServicesTable } from './ServicesTable';

export function AdminTab(props) {
    const {handleInputChange} = props;
    const {isUsersLoading, users, usernameSearch, handleDeleteUser, handleSearchUser,} = props;
    const {
        isOrdersLoading,
        orders,
        orderDescription,
        orderTextSearch,
        handleCreateOrder,
        handleEditOrder,
        handleUpdateOrder,
        orderToEdit,
        handleDeleteOrder,
        handleSearchOrder,
        isOrderEdited,
    } = props;


    
    const panes = [
        {
            menuItem: {key: 'users', icon: 'users', content: 'Users'},
            render: () => (
                <Tab.Pane loading={isUsersLoading}>
                    <UserTable
                        users={users}
                        usernameSearch={usernameSearch}
                        handleInputChange={handleInputChange}
                        handleDeleteUser={handleDeleteUser}
                        handleSearchUser={handleSearchUser}
                    />
                </Tab.Pane>
            )
        },
        {
            menuItem: {key: 'orders', icon: 'laptop', content: 'Orders'},

            render: () => (
                !isOrderEdited ? (
                    <Tab.Pane loading={isOrdersLoading}>
                        <OrderTable
                            orders={orders}
                            orderDescription={orderDescription}
                            orderTextSearch={orderTextSearch}
                            handleInputChange={handleInputChange}
                            handleCreateOrder={handleCreateOrder}
                            handleEditOrder={handleEditOrder}
                            orderToEdit={orderToEdit}
                            handleDeleteOrder={handleDeleteOrder}
                            handleSearchOrder={handleSearchOrder}
                            handleUpdateOrder={handleUpdateOrder}

                        />
                    </Tab.Pane>) : (
                    <Tab.Pane loading={isOrdersLoading}>
                        <EditOrderTable
                            isOrderEdited={isOrderEdited}
                            orderToEdit={orderToEdit}
                            handleEditOrder={handleEditOrder}
                            handleUpdateOrder={handleUpdateOrder}
                        />

                    </Tab.Pane>
                )
            )
        },

        {
            menuItem: { key: 'workers', icon: 'briefcase', content: 'Meistrai' }, // Add the new menu item
            render: () => (
              <Tab.Pane>
                <WorkersTable
                />
              </Tab.Pane>
            )
          },
          {
            menuItem: { key: 'services', icon: 'briefcase', content: 'Servisai' }, // Add the new menu item
            render: () => (
              <Tab.Pane>
                <ServicesTable 
                />
              </Tab.Pane>
            )
          }

    ]

    return (
        <Tab menu={{attached: 'top'}} panes={panes}/>
    )
}

